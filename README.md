# Project Lion 2주차 Mission

# Basic Mission

## 요구사항
1. 게시판에 대한 CRUD를 우선 작성합니다.
    1. 게시판은 게시판 이름에 대한 정보를 가지고 있어야 합니다.
2. 게시글에 대한 CRUD를 작성해 봅시다.
    1. 게시글에는 제목, 본문, 작성자, 비밀번호에 대한 정보가 존재합니다.
    2. 작성된 게시글은 게시판에 속해 있어야 합니다.
    3. 게시글을 삭제하기 위해서는 게시글의 비밀번호가 함깨 제공되어야 합니다.

### 세부 조건
1. 관계형 데이터베이스의 Primary Key와 같은 정보 데이터에 포함하여, 각 자원을 쉽게 식별할 수 있도록 합시다.
2. REST API와 URL의 구조를 잘 생각하여`@RequestMapping`구성을 할 수 있도록 합시다.

> 특히,`post`와`board`의 관계가 요청하는 URL 상에 나타날 수 있도록 해봅시다.

### 프로젝트를 진행하면서 어떤걸 고민했는가?
1. DTO, VO, Entity
2. API 형식이란, Restful 하게 API를 설계하는 방법
    1. 오류 출력해보기
    2. board의 게시글 리스트를 출력할 때, content가 아닌 해당 post의 url 출력
3. 객체 지향적인 설계란 무엇일까

### 게시판에 있는 게시글 리스트를 출력할 때, post의 내용 출력이 아닌 해당 post의 url 출력
게시판 하나의 정보를 불러 올 떄, 게시글 리스트를 출력했습니다. 처음은 게시글 정보가 들어있는 PostDto 리스트를 출력하기로 마음을 먹었고, 
아래와 같이 BoardDto 안의 값으로 PostDto 리스트를 넣어줬습니다.

```java
@Override
@GetMapping("/{board_id}")
public ApiResult<BoardDto> getBoardOne(@PathVariable Long board_id) {
    log.debug("call {} {}",getClass().getName(), board_id);
    Board board = boardService.findBoardOne(board_id);
    return OK(getBoardDto(board));
}

private BoardDto getBoardDto(Board board) {
  return new BoardDto(board.getName(), getPostDtoList(board.getPostList()));
  }
```

하지만 실제 해당 게시글에 대한 내용은 게시글이 클릭했을 떄, 내용이 보여줘야하지 않을까라는 생각을 했고, 
PostDto 리스트가 아닌 post의 작성자와 이름, 그리고 해당 post의 url을 가진 Dto가 필요하다는 것을 알았습니다.

## PostDto -> SimplePostResponse로 변경
PostDto에는 content의 값이 들어가기 때문에 새로운 DTO인 SimplePostResponse을 생성해 해당 객체를 출력했습니다.

```java
public class SimplePostResponse {
   private final String url;

   private final String title;

   private final String writer;

   private static final String HOST = "http://localhost:8080/posts/";

   public SimplePostResponse(String url, String title, String writer) {
      this.url = url;
      this.title = title;
      this.writer = writer;
   }

   public static SimplePostResponse createPostResponse(Long id, String title, String writer) {
      return new SimplePostResponse(HOST + id, title, writer);
   }
	 
  // getter ...
}
```

아래는 Post 도메인 엔티티에서 해당 값으로 변환하는 컨버터를 생성했습니다.

```java
 public SimplePostResponse convertPostToSimplePostResponse() {
     return SimplePostResponse.createPostResponse(this.getId(), this.getTitle(), this.getContent());
 }
```

Board Controller에서 SimplePostResponse 객체를 넣어 출력했습니다.

```java
@Override
@GetMapping("/{board_id}")
public ApiResult<BoardResponse> getBoardOne(@PathVariable Long board_id) {
  log.debug("call {} {}",getClass().getName(), board_id);
  Board board = boardService.findBoardOne(board_id);
  return OK(getBoardDto(board));
}

private BoardResponse getBoardDto(Board board) {
  return new BoardResponse(board.getName(), getPostDtoList(board.getPostList()));
}
```

아래 url을 가진 post 객체 데이터가 나오는 것을 볼 수 있습니다.
<img width="1840" alt="getBoardOne" src="https://user-images.githubusercontent.com/92219795/154914579-fcc75ac8-93ce-47b9-bf57-81b91e45aec1.png">

아래 해당 url로 들어갔을 때, 해당 post의 내용을 볼 수 있습니다.
<img width="1840" alt="getPostOne" src="https://user-images.githubusercontent.com/92219795/154914793-17548cda-3da0-4f6d-a7a6-9f80a70bc73f.png">

### Board 객체 하나를 가져오는 전체적인 흐름
해당 Board 엔티티에 post list는 `@OneToMany`의 기본값인 `etch = FetchType.LAZY` 이기 때문에 프록시 객체가 들어가 있다가 
controller에서 post list를 호출하면서 해당 프록시 객체의 진짜 값을 참조하게 된다.
<img width="691" alt="전체적인흐름" src="https://user-images.githubusercontent.com/92219795/154925494-896eb32b-8e2f-4460-a575-e484fc0d38fb.png">


그 외, crud도 다 구현을 했으며 http 메서드에 따라 적절하게 대응을 합니다.

## URL 경로

- GET : 조회
  - {{LOCALHOST}}:{{PORT}}/boards/1 
- POST : 추가
  - {{LOCALHOST}}:{{PORT}}/boards
- PATCH : 수정
  - 수정에 PUT이 아닌 PATCH를 사용한 이유는 변경하지 않은 데이터는 유지하기 위해서입니다.
  - {{LOCALHOST}}:{{PORT}}/boards/1
- DLETE : 삭제
  - {{LOCALHOST}}:{{PORT}}/boards/1 

### 궁금한 점

1. API 문서는 어떻게 만들지?
   1. API 문서를 만들 수 있도록 지원하는 다양한 라이브러리가 존재하는 듯했지만, 프로젝트 설계에 대해 집중한 나머지 위의 궁금증을 해결하지 못했습니다.

### 어떤걸 고민했는가?
1. DTO, VO, Entity
   1. DTO는 값을 전달하는 객체라는 것을 알았고, 3-Tier에서 생각한다면 애플리케이션 레이어 와 프레젠테이션 레이어 사이에 값을 전달하기 위한 객체라는 것을 알았습니다.
   2. VO는 값 객체이며 DTO 안이나 Entity 안에 값을 정의하며, 해당 값의 유효성 검사 등 값에 대한 로직이 들어가 있습니다.
   3. Entity은 도메인 엔티티이며, 데이터베이스에서 값을 입력하고 출력하기 위해 존재합니다. 만약 단순 CRUD 프로젝트이면 해당 엔티티를 없애고 DTO로 데이터를 주고 받을 수 있지만 비즈니스 로직이 들어간 서비스 레이어에서 다른 애플리케이션이 접근하려면 해당 DTO에 값을 맞춰야하기 때문에 유지보수 측면에서 매우 어려움을 겪습니다.
2. API 형식이란, Restful 하게 API를 설계하는 방법
   1. board의 게시글 리스트를 출력할 때, content가 아닌 해당 post의 url 출력하면서 화면이 필요 없어도 데이터의 위치를 출력해줬습니다. 하지만 Restful하게 해당 데이터가 어떤 데이터인지 확인할 수 있는 길이 없는 반쪽짜리 API가 탄생했습니다.
   2. 오류 메시지 전달은 아쉽게도 구현하지 못했습니다. 실제로 시간이 더 많았더라면 @ControllerAdvice 애너테이션을 이용해 오류를 통합적으로 관리하는 컨틀롤러어드바이스를 구현해 오류메시지를 별도로 출력할 생각이었습니다.
3. 객체지향적인 설계란 무엇일까
   1. 해당 프로젝트를 진행하면서 객체지향적인 설계란 무엇일까라는 고민을 많이 했습니다. 객체지향 설계를 조금 더 깊게 알기 위해 객체지향의 사실과 오해라는 책을 읽으며 해당 프로젝트에 객체 간의 협력에 집중하려고 노력했고, 객체 마다 가지는 책임과 역할에 대해 심도있게 고민하면서 해당 응답 메시지에는 어떤 책임을 가지는 메시지가 나가야하는지 고민을 많이한 계기가 됐습니다.
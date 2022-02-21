package tis.project.lion.postproject.domain.image;


import tis.project.lion.postproject.domain.post.Post;

import javax.persistence.*;

@Entity
@DiscriminatorValue("post_image")
public class PostImage extends Image{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	public PostImage(String uploadFileName, String storeFileName) {
		super(uploadFileName, storeFileName);
	}

	public PostImage(String uploadFileName, String storeFileName, Post post) {
		super(uploadFileName, storeFileName);
		this.post = post;
	}

	public PostImage() {}

	public void setPost(Post post) {
		this.post = post;
	}

	public Post getPost() {
		return post;
	}
}

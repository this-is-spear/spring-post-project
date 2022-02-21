package tis.project.lion.postproject.domain.image;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "image_type")
public abstract class Image {
    @Id
    @GeneratedValue
    @Column(name = "images_id")
    private Long id;
    private String uploadFileName;
    private String storeFileName;

    public Image(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }

    public Image() {}

    public Long getId() {
        return id;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public String getStoreFileName() {
        return storeFileName;
    }
}

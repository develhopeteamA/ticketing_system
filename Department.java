import javax.persistence.*;
import java.sql.Timestamp;

    @Entity
    @Table(name = "department")
    public class Department {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "department_id")
        private Long id;

        @Column(name = "department_name")
        private String name;

        @Column(name = "department_description")
        private String description;

        @ManyToOne
        @JoinColumn(name = "department_director")
        private User director;

        @Column(name = "created_on")
        private Timestamp createdOn;

        @Column(name = "created_by")
        private Long createdBy;

        @Column(name = "updated_on")
        private Timestamp updatedOn;

        @Column(name = "updated_by")
        private Long updatedBy;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public User getDirector() {
            return director;
        }

        public void setDirector(User director) {
            this.director = director;
        }

        public Timestamp getCreatedOn() {
            return createdOn;
        }

        public void setCreatedOn(Timestamp createdOn) {
            this.createdOn = createdOn;
        }

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public Timestamp getUpdatedOn() {
            return updatedOn;
        }

        public void setUpdatedOn(Timestamp updatedOn) {
            this.updatedOn = updatedOn;
        }

        public Long getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Long updatedBy) {
            this.updatedBy = updatedBy;
        }

}

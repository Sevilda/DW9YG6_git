    package hu.javatpoint.repository;  
    import org.springframework.data.repository.CrudRepository;  
    import hu.javatpoint.model.Student;  
    public interface StudentRepository extends CrudRepository<Student, Integer>  
    {  
    }  
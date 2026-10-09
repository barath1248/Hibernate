package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.connection.ConnectionProvider;
import com.entity.Student;

public class OperationDao {
	public static String insert(List<Student> data) {
		Session session = ConnectionProvider.getConnection().openSession();
		Transaction transaction = session.beginTransaction();
		for (Student value : data) {
			session.persist(value);
		}
		transaction.commit();
		session.close();
		return "data inserted";
	}

	public static List<Student> getData(List<Student> data) {
		Session session = ConnectionProvider.getConnection().openSession();
		Transaction transaction = session.beginTransaction();
		List<Student> result = new ArrayList<Student>();
		for (Student value : data) {
			result.add(session.get(Student.class, value.getId()));
		}
		transaction.commit();
		session.close();
		return result;
	}
}

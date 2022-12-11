package main.java.by.server.service.impl;

import main.java.by.client.entity.Student;
import main.java.by.client.entity.user.User;
import main.java.by.server.dao.StudentServerDAO;
import main.java.by.server.service.StudentServerService;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentServerServiceImpl implements StudentServerService {
    private final StudentServerDAO studentDAO;

    public StudentServerServiceImpl(StudentServerDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public boolean edit(Student newValue) {
        List<Student> students = this.studentDAO.getAll();
        Student toEdit = students.stream()
                .filter(s -> s.getId() == newValue.getId())
                .findFirst().orElse(null);
        if (toEdit == null) {
            return false;
        }

        if ((toEdit.getLastModification() != null)
                && newValue.getLastModification().isBefore(toEdit.getLastModification())) {
            return false;
        }

        toEdit.setName(newValue.getName());
        toEdit.setBirthday(newValue.getBirthday());
        toEdit.setCharacteristic(newValue.getCharacteristic());
        toEdit.setLastModification(LocalDateTime.now());

        try {
            this.studentDAO.rewriteStudents(students);
        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    @Override
    public List<Student> getAll() {
        return this.studentDAO.getAll();
    }

    @Override
    public Student get(int id) {
        return studentDAO.get(id);
    }

    @Override
    public boolean create(Student student) {
        List<Student> students = this.studentDAO.getAll();
        if (students.isEmpty()) {
            student.setId(1);
        } else {
            Student maxIdStudent = Collections.max(students, Comparator.comparing(Student::getId));
            student.setId(maxIdStudent.getId() + 1);
        }

        students.add(student);
        try {
            this.studentDAO.rewriteStudents(students);
        } catch (FileNotFoundException e) {
            return false;
        }

        return true;
    }

    @Override
    public User login(User user) {
        User existedUser  = this.studentDAO.userExists(user);
        if ((existedUser != null)
                && existedUser.getPassword().equals(user.getPassword())) {
            return existedUser;
        }

        return null;
    }

    @Override
    public User register(User user) {
        List<User> users = this.studentDAO.getAllUsers();
        if (users.stream().anyMatch(u -> u.getLogin().equals(user.getLogin()))) {
            return null;
        }

        if (users.isEmpty()) {
            user.setId(1);
        } else {
            User maxIdStudent = Collections.max(users, Comparator.comparing(User::getId));
            user.setId(maxIdStudent.getId() + 1);
        }

        users.add(user);
        try {
            this.studentDAO.rewriteUsers(users);
        } catch (FileNotFoundException e) {
            return null;
        }

        return user;
    }
}

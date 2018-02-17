package br.com.wlsnprogramming.aprendendojava.javacore.zf000padroesdeprojeto.classes;

public class Pessoa {

    private String firsName;
    private String lastName;
    private String middleName;
    private String username;

    public Pessoa(){

    }

    public Pessoa(String firsName, String lastName, String middleName, String username) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.username = username;
    }

    public static class PessoaBuilder {
        private String firsName;
        private String lastName;
        private String middleName;
        private String username;

        public PessoaBuilder(String firsName) {
            this.firsName = firsName;
        }

        public PessoaBuilder firstName(String firstName) {
            this.firsName = firstName;
            return this;
        }

        public PessoaBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PessoaBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PessoaBuilder username(String username) {
            this.username = username;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(firsName, lastName, middleName, username);
        }
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

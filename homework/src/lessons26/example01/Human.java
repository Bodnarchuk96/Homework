package lessons26.example01;

public class Human {

        private String name;
        private int age;
        private UserType userType;

        public Human(String name, int age, UserType userType) {
            this.name = name;
            this.age = age;
            this.userType = userType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public UserType getUserType() {
            return userType;
        }

        public void setUserType(UserType userType) {
            this.userType = userType;
        }
    }


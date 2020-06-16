package pojo;

public class LoginData {
        private boolean confirmUserData;
        private boolean newUser;
        private String sessionId;
        private String userId;


        // Getter Methods

        public boolean getConfirmUserData() {
            return confirmUserData;
        }

        public boolean getNewUser() {
            return newUser;
        }

        public String getSessionId() {
            return sessionId;
        }

        public String getUserId() {
            return userId;
        }

        // Setter Methods

        public void setConfirmUserData(boolean confirmUserData) {
            this.confirmUserData = confirmUserData;
        }

        public void setNewUser(boolean newUser) {
            this.newUser = newUser;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

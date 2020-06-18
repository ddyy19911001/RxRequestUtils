package com.dy.myrequestutils;


public class TokenInfo  {

    /**
     * code : 200
     * msg : success
     * time : 1573788102
     * data : {"access_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC92aWRlby5jb21cL2FwaVwvbG9naW4iLCJpYXQiOjE1NzM3ODgxMDIsImV4cCI6MTU3MzgyNDEwMiwibmJmIjoxNTczNzg4MTAyLCJqdGkiOiJwUnc1QktKZUplOFprUE0yIiwic3ViIjo2LCJwcnYiOiJmNmI3MTU0OWRiOGMyYzQyYjc1ODI3YWE0NGYwMmI3ZWU1MjlkMjRkIn0.mpwPSzMwErJtnBGcm7KE5gkQdjCa2XCmci4Qx-e2GZE","token_type":"bearer","expires_in":36000,"user_id":"EbvyDVeR1PdMgxqN"}
     */

    private int code;
    private String msg;
    private int time;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", time=" + time +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC92aWRlby5jb21cL2FwaVwvbG9naW4iLCJpYXQiOjE1NzM3ODgxMDIsImV4cCI6MTU3MzgyNDEwMiwibmJmIjoxNTczNzg4MTAyLCJqdGkiOiJwUnc1QktKZUplOFprUE0yIiwic3ViIjo2LCJwcnYiOiJmNmI3MTU0OWRiOGMyYzQyYjc1ODI3YWE0NGYwMmI3ZWU1MjlkMjRkIn0.mpwPSzMwErJtnBGcm7KE5gkQdjCa2XCmci4Qx-e2GZE
         * token_type : bearer
         * expires_in : 36000
         * user_id : EbvyDVeR1PdMgxqN
         */

        private String access_token;
        private String token_type;
        private int expires_in;
        private String user_id;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "access_token='" + access_token + '\'' +
                    ", token_type='" + token_type + '\'' +
                    ", expires_in=" + expires_in +
                    ", user_id='" + user_id + '\'' +
                    '}';
        }
    }
}

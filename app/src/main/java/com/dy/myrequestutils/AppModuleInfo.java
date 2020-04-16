package com.dy.myrequestutils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppModuleInfo {


    /**
     * code : 200
     * msg : success
     * time : 1579422608
     * data : {"index":{"code":"index","name":"首页","icon_url":{"default":"/images/client_module_icon/index_default.png","choose":"/images/client_module_icon/profile_choose.png"},"children":[{"id":-100,"name":"推荐"},{"id":-101,"name":"最新"},{"id":-102,"name":"排行"}]},"video":{"code":"video","name":"视频","icon_url":{"default":"/images/client_module_icon/video_default.png","choose":"/images/client_module_icon/video_choose.png"},"children":[{"id":-200,"name":"推荐"},{"id":-201,"name":"最新"},{"id":-202,"name":"排行"},{"id":2,"name":"不找了找不到了"}]},"category":{"code":"category","name":"分类","icon_url":{"default":"/images/client_module_icon/category_default.png","choose":"/images/client_module_icon/category_choose.png"}},"star":{"code":"star","name":"收藏","icon_url":{"default":"/images/client_module_icon/star_default.png","choose":"/images/client_module_icon/star_choose.png"}},"profile":{"code":"profile","name":"我的","icon_url":{"default":"/images/client_module_icon/profile_default.png","choose":"/images/client_module_icon/profile_choose.png"}}}
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

    public static class DataBean {
        /**
         * index : {"code":"index","name":"首页","icon_url":{"default":"/images/client_module_icon/index_default.png","choose":"/images/client_module_icon/profile_choose.png"},"children":[{"id":-100,"name":"推荐"},{"id":-101,"name":"最新"},{"id":-102,"name":"排行"}]}
         * video : {"code":"video","name":"视频","icon_url":{"default":"/images/client_module_icon/video_default.png","choose":"/images/client_module_icon/video_choose.png"},"children":[{"id":-200,"name":"推荐"},{"id":-201,"name":"最新"},{"id":-202,"name":"排行"},{"id":2,"name":"不找了找不到了"}]}
         * category : {"code":"category","name":"分类","icon_url":{"default":"/images/client_module_icon/category_default.png","choose":"/images/client_module_icon/category_choose.png"}}
         * star : {"code":"star","name":"收藏","icon_url":{"default":"/images/client_module_icon/star_default.png","choose":"/images/client_module_icon/star_choose.png"}}
         * profile : {"code":"profile","name":"我的","icon_url":{"default":"/images/client_module_icon/profile_default.png","choose":"/images/client_module_icon/profile_choose.png"}}
         */

        private IndexBean index;
        private VideoBean video;
        private CategoryBean category;
        private StarBean star;
        private ProfileBean profile;

        public IndexBean getIndex() {
            return index;
        }

        public void setIndex(IndexBean index) {
            this.index = index;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public CategoryBean getCategory() {
            return category;
        }

        public void setCategory(CategoryBean category) {
            this.category = category;
        }

        public StarBean getStar() {
            return star;
        }

        public void setStar(StarBean star) {
            this.star = star;
        }

        public ProfileBean getProfile() {
            return profile;
        }

        public void setProfile(ProfileBean profile) {
            this.profile = profile;
        }

        public static class IndexBean {
            /**
             * code : index
             * name : 首页
             * icon_url : {"default":"/images/client_module_icon/index_default.png","choose":"/images/client_module_icon/profile_choose.png"}
             * children : [{"id":-100,"name":"推荐"},{"id":-101,"name":"最新"},{"id":-102,"name":"排行"}]
             */

            private String code;
            private String name;
            private IconUrlBean icon_url;
            private List<ChildrenBean> children;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public IconUrlBean getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(IconUrlBean icon_url) {
                this.icon_url = icon_url;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class IconUrlBean{
                /**
                 * default : /images/client_module_icon/index_default.png
                 * choose : /images/client_module_icon/profile_choose.png
                 */

                @SerializedName("default")
                private String defaultX;
                private String choose;

                public String getDefaultX() {
                    return defaultX;
                }

                public void setDefaultX(String defaultX) {
                    this.defaultX = defaultX;
                }

                public String getChoose() {
                    return choose;
                }

                public void setChoose(String choose) {
                    this.choose = choose;
                }
            }

            public static class ChildrenBean {
                /**
                 * id : -100
                 * name : 推荐
                 */

                private String id;
                private String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class VideoBean {
            /**
             * code : video
             * name : 视频
             * icon_url : {"default":"/images/client_module_icon/video_default.png","choose":"/images/client_module_icon/video_choose.png"}
             * children : [{"id":-200,"name":"推荐"},{"id":-201,"name":"最新"},{"id":-202,"name":"排行"},{"id":2,"name":"不找了找不到了"}]
             */

            private String code;
            private String name;
            private IconUrlBeanX icon_url;
            private List<ChildrenBeanX> children;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public IconUrlBeanX getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(IconUrlBeanX icon_url) {
                this.icon_url = icon_url;
            }

            public List<ChildrenBeanX> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBeanX> children) {
                this.children = children;
            }

            public static class IconUrlBeanX {
                /**
                 * default : /images/client_module_icon/video_default.png
                 * choose : /images/client_module_icon/video_choose.png
                 */

                @SerializedName("default")
                private String defaultX;
                private String choose;

                public String getDefaultX() {
                    return defaultX;
                }

                public void setDefaultX(String defaultX) {
                    this.defaultX = defaultX;
                }

                public String getChoose() {
                    return choose;
                }

                public void setChoose(String choose) {
                    this.choose = choose;
                }
            }

            public static class ChildrenBeanX {
                /**
                 * id : -200
                 * name : 推荐
                 */

                private String id;
                private String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class CategoryBean {
            /**
             * code : category
             * name : 分类
             * icon_url : {"default":"/images/client_module_icon/category_default.png","choose":"/images/client_module_icon/category_choose.png"}
             */

            private String code;
            private String name;
            private IconUrlBeanXX icon_url;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public IconUrlBeanXX getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(IconUrlBeanXX icon_url) {
                this.icon_url = icon_url;
            }

            public static class IconUrlBeanXX {
                /**
                 * default : /images/client_module_icon/category_default.png
                 * choose : /images/client_module_icon/category_choose.png
                 */

                @SerializedName("default")
                private String defaultX;
                private String choose;

                public String getDefaultX() {
                    return defaultX;
                }

                public void setDefaultX(String defaultX) {
                    this.defaultX = defaultX;
                }

                public String getChoose() {
                    return choose;
                }

                public void setChoose(String choose) {
                    this.choose = choose;
                }
            }
        }

        public static class StarBean {
            /**
             * code : star
             * name : 收藏
             * icon_url : {"default":"/images/client_module_icon/star_default.png","choose":"/images/client_module_icon/star_choose.png"}
             */

            private String code;
            private String name;
            private IconUrlBeanXXX icon_url;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public IconUrlBeanXXX getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(IconUrlBeanXXX icon_url) {
                this.icon_url = icon_url;
            }

            public static class IconUrlBeanXXX {
                /**
                 * default : /images/client_module_icon/star_default.png
                 * choose : /images/client_module_icon/star_choose.png
                 */

                @SerializedName("default")
                private String defaultX;
                private String choose;

                public String getDefaultX() {
                    return defaultX;
                }

                public void setDefaultX(String defaultX) {
                    this.defaultX = defaultX;
                }

                public String getChoose() {
                    return choose;
                }

                public void setChoose(String choose) {
                    this.choose = choose;
                }
            }
        }

        public static class ProfileBean {
            /**
             * code : profile
             * name : 我的
             * icon_url : {"default":"/images/client_module_icon/profile_default.png","choose":"/images/client_module_icon/profile_choose.png"}
             */

            private String code;
            private String name;
            private IconUrlBeanXXXX icon_url;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public IconUrlBeanXXXX getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(IconUrlBeanXXXX icon_url) {
                this.icon_url = icon_url;
            }

            public static class IconUrlBeanXXXX {
                /**
                 * default : /images/client_module_icon/profile_default.png
                 * choose : /images/client_module_icon/profile_choose.png
                 */

                @SerializedName("default")
                private String defaultX;
                private String choose;

                public String getDefaultX() {
                    return defaultX;
                }

                public void setDefaultX(String defaultX) {
                    this.defaultX = defaultX;
                }

                public String getChoose() {
                    return choose;
                }

                public void setChoose(String choose) {
                    this.choose = choose;
                }
            }
        }
    }
}

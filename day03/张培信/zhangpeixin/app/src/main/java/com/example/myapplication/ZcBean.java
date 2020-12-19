package com.example.myapplication;

import java.util.List;

public class ZcBean {

    /**
     * status : {"statusCode":100,"message":"请求成功！","serverTime":"2020-08-04 16:34:01"}
     * data : {"total":11,"list":[{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:56:10","detailUrl":"","status":0,"title":"【汉服美图】唐制婚礼","content":"","cover":"","type":0,"commID":1382,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021615103.jpg"},{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021620641.jpg"},{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021626757.jpg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:56:08","detailUrl":"","status":0,"title":"【汉服美图】秋风一曲二十载，望断昆仑鸟飞桓。","content":"","cover":"","type":0,"commID":1381,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2018/1216/20181216070906525.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:56:07","detailUrl":"","status":0,"title":"【汉服美景】水晶帘动微风起","content":"","cover":"","type":0,"commID":1380,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:55:47","detailUrl":"","status":0,"title":"【汉服美图】桂魄初生秋露微，轻罗已薄未更衣。","content":"","cover":"","type":0,"commID":1379,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2018/1217/20181217104003223.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1217/20181217104003865.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1217/20181217104003642.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:55:37","detailUrl":"","status":0,"title":"【汉服私影】绿酒莫辞今日醉","content":"","cover":"","type":0,"commID":1378,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612072808736.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:55:24","detailUrl":"","status":0,"title":"【汉服私影】昨夜西风凋碧树","content":"","cover":"","type":0,"commID":1377,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:54:59","detailUrl":"","status":0,"title":"【庐山雪】雪与汉服 点缀着这个冬天的美","content":"","cover":"","type":0,"commID":1376,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2018/1219/20181219085847422.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1219/20181219085847587.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1219/20181219085847857.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-26 09:29:25","detailUrl":"","status":0,"title":"重庆\u201c任性\u201d妹纸 逛街穿汉服上班穿汉服","content":"","cover":"","type":0,"commID":1165,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2015/0405/20150405095020373.jpg"}]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-24 17:09:24","detailUrl":"","status":0,"title":"【汉服美图】秋。","content":"","cover":"","type":0,"commID":1147,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-19 18:43:42","detailUrl":"","status":0,"title":"【汉服武侠】侠客剑，走偏锋","content":"","cover":"","type":0,"commID":1116,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612074957115.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612074957641.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612074958717.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-19 18:42:41","detailUrl":"","status":0,"title":"湖北经济学院汉服樱花照","content":"","cover":"","type":0,"commID":1115,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2015/0326/20150326121003502.jpg"}]}],"comTotal":0}
     */

    private StatusBean status;
    private DataBean data;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class StatusBean {
        /**
         * statusCode : 100
         * message : 请求成功！
         * serverTime : 2020-08-04 16:34:01
         */

        private int statusCode;
        private String message;
        private String serverTime;

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getServerTime() {
            return serverTime;
        }

        public void setServerTime(String serverTime) {
            this.serverTime = serverTime;
        }
    }

    public static class DataBean {
        /**
         * total : 11
         * list : [{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:56:10","detailUrl":"","status":0,"title":"【汉服美图】唐制婚礼","content":"","cover":"","type":0,"commID":1382,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021615103.jpg"},{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021620641.jpg"},{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021626757.jpg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:56:08","detailUrl":"","status":0,"title":"【汉服美图】秋风一曲二十载，望断昆仑鸟飞桓。","content":"","cover":"","type":0,"commID":1381,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2018/1216/20181216070906525.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:56:07","detailUrl":"","status":0,"title":"【汉服美景】水晶帘动微风起","content":"","cover":"","type":0,"commID":1380,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:55:47","detailUrl":"","status":0,"title":"【汉服美图】桂魄初生秋露微，轻罗已薄未更衣。","content":"","cover":"","type":0,"commID":1379,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2018/1217/20181217104003223.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1217/20181217104003865.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1217/20181217104003642.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:55:37","detailUrl":"","status":0,"title":"【汉服私影】绿酒莫辞今日醉","content":"","cover":"","type":0,"commID":1378,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612072808736.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:55:24","detailUrl":"","status":0,"title":"【汉服私影】昨夜西风凋碧树","content":"","cover":"","type":0,"commID":1377,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[]},{"id":0,"reptileArticleID":0,"createTime":"2020-02-14 17:54:59","detailUrl":"","status":0,"title":"【庐山雪】雪与汉服 点缀着这个冬天的美","content":"","cover":"","type":0,"commID":1376,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2018/1219/20181219085847422.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1219/20181219085847587.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2018/1219/20181219085847857.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-26 09:29:25","detailUrl":"","status":0,"title":"重庆\u201c任性\u201d妹纸 逛街穿汉服上班穿汉服","content":"","cover":"","type":0,"commID":1165,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2015/0405/20150405095020373.jpg"}]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-24 17:09:24","detailUrl":"","status":0,"title":"【汉服美图】秋。","content":"","cover":"","type":0,"commID":1147,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-19 18:43:42","detailUrl":"","status":0,"title":"【汉服武侠】侠客剑，走偏锋","content":"","cover":"","type":0,"commID":1116,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612074957115.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612074957641.jpeg"},{"filePath":"http://static.aihanfu.net/uploadfile/2019/0612/20190612074958717.jpeg"}]},{"id":0,"reptileArticleID":0,"createTime":"2019-12-19 18:42:41","detailUrl":"","status":0,"title":"湖北经济学院汉服樱花照","content":"","cover":"","type":0,"commID":1115,"sourceStr":"爱汉服","author":"","cagetory":"","listImages":"","qiYuId":"","keyword":"","filePathList":[{"filePath":"http://static.aihanfu.net/uploadfile/2015/0326/20150326121003502.jpg"}]}]
         * comTotal : 0
         */

        private int total;
        private int comTotal;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getComTotal() {
            return comTotal;
        }

        public void setComTotal(int comTotal) {
            this.comTotal = comTotal;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 0
             * reptileArticleID : 0
             * createTime : 2020-02-14 17:56:10
             * detailUrl :
             * status : 0
             * title : 【汉服美图】唐制婚礼
             * content :
             * cover :
             * type : 0
             * commID : 1382
             * sourceStr : 爱汉服
             * author :
             * cagetory :
             * listImages :
             * qiYuId :
             * keyword :
             * filePathList : [{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021615103.jpg"},{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021620641.jpg"},{"filePath":"http://static.aihanfu.net/uploadfile/2017/0227/20170227021626757.jpg"}]
             */

            private int id;
            private int reptileArticleID;
            private String createTime;
            private String detailUrl;
            private int status;
            private String title;
            private String content;
            private String cover;
            private int type;
            private int commID;
            private String sourceStr;
            private String author;
            private String cagetory;
            private String listImages;
            private String qiYuId;
            private String keyword;
            private List<FilePathListBean> filePathList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getReptileArticleID() {
                return reptileArticleID;
            }

            public void setReptileArticleID(int reptileArticleID) {
                this.reptileArticleID = reptileArticleID;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getCommID() {
                return commID;
            }

            public void setCommID(int commID) {
                this.commID = commID;
            }

            public String getSourceStr() {
                return sourceStr;
            }

            public void setSourceStr(String sourceStr) {
                this.sourceStr = sourceStr;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getCagetory() {
                return cagetory;
            }

            public void setCagetory(String cagetory) {
                this.cagetory = cagetory;
            }

            public String getListImages() {
                return listImages;
            }

            public void setListImages(String listImages) {
                this.listImages = listImages;
            }

            public String getQiYuId() {
                return qiYuId;
            }

            public void setQiYuId(String qiYuId) {
                this.qiYuId = qiYuId;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }

            public List<FilePathListBean> getFilePathList() {
                return filePathList;
            }

            public void setFilePathList(List<FilePathListBean> filePathList) {
                this.filePathList = filePathList;
            }

            public static class FilePathListBean {
                /**
                 * filePath : http://static.aihanfu.net/uploadfile/2017/0227/20170227021615103.jpg
                 */

                private String filePath;

                public String getFilePath() {
                    return filePath;
                }

                public void setFilePath(String filePath) {
                    this.filePath = filePath;
                }
            }
        }
    }
}

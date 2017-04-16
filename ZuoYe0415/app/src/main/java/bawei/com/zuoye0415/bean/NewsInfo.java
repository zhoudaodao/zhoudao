package bawei.com.zuoye0415.bean;

import java.util.List;

/**
 * date:2017/4/15
 * author:周道(leovo)
 * funcation:
 */

public class NewsInfo {

    /**
     * data : [{"id":"","name":"全部药品"},{"id":"2","name":"西药"},{"id":"3","name":"中药"}]
     * status : 10000
     */

    private int status;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id :
         * name : 全部药品
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

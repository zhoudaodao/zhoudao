package bawei.com.zhoudao20170407;

import java.util.List;

/**
 * date:2017/4/7
 * author:周道(leovo)
 * funcation:
 */

public class Book {

    private List<ContentsBean> contents;

    public List<ContentsBean> getContents() {
        return contents;
    }

    public void setContents(List<ContentsBean> contents) {
        this.contents = contents;
    }

    public static class ContentsBean {
        /**
         * id :
         * parentId :
         * sort :
         * clickCount : null
         * name : 推荐文章
         * graduation : 0
         */

        private String id;
        private String parentId;
        private String sort;
        private Object clickCount;
        private String name;
        private String graduation;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public Object getClickCount() {
            return clickCount;
        }

        public void setClickCount(Object clickCount) {
            this.clickCount = clickCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGraduation() {
            return graduation;
        }

        public void setGraduation(String graduation) {
            this.graduation = graduation;
        }
    }
}

package tech.bilian.myblog.utils;

public class PathUtil {
    public static String seperator = System.getProperty("file.separator");

    /**
     * 获得基本路径
     *
     * @return
     */
    public static String getImageBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";

        if(os.toLowerCase().startsWith("win")){
            basePath = "F:/projectdev/image";
        }
        else {
            basePath = "/home/haru/image";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    /**
     * 获得店铺图片的路径
     *
     * @param
     * @return
     */
    public static String getShopImagePath(long ownerId, long articleId){
        String imagePath = "/upload/item/blog/" + ownerId + "/" + articleId + "/";
        return imagePath.replace("/", seperator);
    }

    public static String getOriginalImagePath(long ownerId, long articleId){
        String imagePath = "/upload/item/blog/" + ownerId + "/" + articleId + "/";
        return imagePath.replace("/", seperator);
    }
}

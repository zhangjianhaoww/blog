package tech.bilian.myblog.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将commonsMultipartFile转换为File
     *
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }catch(IllegalStateException e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图，返回新生成图片的相对路径
     *
     * @param
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail (File imageFile, String targetAddr) throws Exception{

        //有系统给上传图片命名，避免图片名重复
        String realFileName = getRandomFileName();
        //获取图片格式名
        String extension = getFileExtension(imageFile.getName());

        makeDirPath(targetAddr);

        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("当前相对路径： " + relativeAddr);
        File dest = new File(PathUtil.getImageBasePath() + relativeAddr);
        logger.debug("完整路径： " + dest);
        try{
            Thumbnails.of(imageFile).size(200, 200).outputQuality(0.8).toFile(dest);

        }catch (IOException e){

            logger.error(e.toString());
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());

        }
        return relativeAddr;
    }



    public static void saveOriginalImage (Image image, String targetAddr) throws Exception{

        //有系统给上传图片命名，避免图片名重复
        String realFileName = getRandomFileName();
        //获取图片格式名
        String extension = getFileExtension(image.getName());

        makeDirPath(targetAddr);

        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("当前相对路径： " + relativeAddr);
        File dest = new File(PathUtil.getImageBasePath() + relativeAddr);
        logger.debug("完整路径： " + dest);

    }




    /**
     * 创建目标路径所涉及的目录（递归创建）
     *
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImageBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }


    private static void makeOriginalDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImageBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件的拓展名
     *
     * @param
     * @return
     */
    private static String getFileExtension(String fileName) {
        //  String originalFileName = thumbnail.getName();
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名： 当前年月日时分秒加5位随机数
     * @return
     */
    private static String getRandomFileName() {
        int rannum = random.nextInt(89999) + 1000;
        String nowTimeStr = simpleDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }
}

package tech.bilian.myblog.utils;

import java.io.InputStream;

public class Image {
    //图片名称
    private String name;

    //图片输入流
    private InputStream ImageInputStream;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InputStream getImageInputStream() {
        return ImageInputStream;
    }

    public void setImageInputStream(InputStream imageInputStream) {
        ImageInputStream = imageInputStream;
    }

    public Image(String name, InputStream imageInputStream) {
        this.name = name;
        ImageInputStream = imageInputStream;
    }
}

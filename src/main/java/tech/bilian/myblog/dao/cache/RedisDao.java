package tech.bilian.myblog.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import tech.bilian.myblog.pojo.Article;

/**
 * 使用redis进行缓存
 * 使用protostuff进行序列化
 */
public class RedisDao {
    private final JedisPool jedisPool;

    private RuntimeSchema<Article> schema = RuntimeSchema.createFrom(Article.class);

    public RedisDao(String ip, int port){
        jedisPool = new JedisPool(ip, port);
    }

    //从缓存中获取文章
    public Article getArticle(long id){
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "article:" + id;
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes != null){
                    //通过schema获取空对象
                    Article article = schema.newMessage();

                    ProtobufIOUtil.mergeFrom(bytes, article, schema);
                    //反序列
                    return article;
                }

                //将类内部序列化（自定义序列化方式 protostuff）
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    //添加到缓存
    public String putAtricle(Article article){

        try{
            Jedis jedis = jedisPool.getResource();
            String key ="article:" + article.getArticleId();
            byte[] bytes = ProtobufIOUtil.toByteArray(article, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
            //数据缓存时间为一个小时
            int timeout = 60 * 60;
            String result = jedis.setex(key.getBytes(), timeout, bytes);
            return result;

        }catch (Exception e){

        }



        return null;
    }

}

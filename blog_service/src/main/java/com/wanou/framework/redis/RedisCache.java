package com.wanou.framework.redis;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.wanou.common.constant.Constants;
import com.wanou.project.system.domain.SysDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * spring redis 工具类
 *
 * @author ruoyi
 **/
@SuppressWarnings(value = { "unchecked", "rawtypes" })
@Component
public class RedisCache
{
    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value)
    {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit)
    {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout)
    {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key Redis键
     * @param timeout 超时时间
     * @param unit 时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit)
    {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 删除单个对象
     *
     * @param key
     */
    public boolean deleteObject(final String key)
    {
        return redisTemplate.delete(key);
    }

    /**
     * 删除集合对象
     *
     * @param collection 多个对象
     * @return
     */
    public long deleteObject(final Collection collection)
    {
        return redisTemplate.delete(collection);
    }

    /**
     * 缓存List数据
     *
     * @param key 缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> long setCacheList(final String key, final List<T> dataList)
    {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public <T> List<T> getCacheList(final String key)
    {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存Set
     *
     * @param key 缓存键值
     * @param dataSet 缓存的数据
     * @return 缓存数据的对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet)
    {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得缓存的set
     *
     * @param key
     * @return
     */
    public <T> Set<T> getCacheSet(final String key)
    {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存Map
     *
     * @param key
     * @param dataMap
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap)
    {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得缓存的Map
     *
     * @param key
     * @return
     */
    public <T> Map<String, T> getCacheMap(final String key)
    {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @param value 值
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value)
    {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public <T> T getCacheMapValue(final String key, final String hKey)
    {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 获取hash大key下所有小key
     * @param redisKey
     * @return
     */
    public Set getCacheMapKeys(final String redisKey){
        HashOperations hashOperations = redisTemplate.opsForHash();
        return hashOperations.keys(redisKey);
    }

    /**
     * 获取多个Hash中的数据
     *
     * @param key Redis键
     * @param hKeys Hash键集合
     * @return Hash对象集合
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys)
    {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern)
    {
        return redisTemplate.keys(pattern);
    }

    /**
     * 从左边往redis集合里添加数据
     */
    public <T> void leftPushList(String key,final T data){
        BoundListOperations boundListOperations = redisTemplate.boundListOps(key);
        boundListOperations.leftPush(JSON.toJSONString(data));
        //redisTemplate.opsForList().leftPush(key, JSON.toJSONString(data));
    }

    /**
     * 从右边移除元素
     */
    public <T> T rightPopList(String key,Class<T> clazz){
        BoundListOperations boundListOperations = redisTemplate.boundListOps(key);
        Object o = boundListOperations.rightPop();
        if(o == null){
            return null;
        }
        return JSON.parseObject(o.toString(),clazz);
    }

    public <T> List<T> boundRightPopListValueRang(String key,Class<T> clazz,int count){
        BoundListOperations boundListOperations = redisTemplate.boundListOps(key);
        List<T> resultList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Object o = boundListOperations.rightPop();
            if(o == null){
                break;
            }
            resultList.add(JSON.parseObject(o.toString(),clazz));
        }

        return resultList;
    }

    /**
     * 返回list长度
     * @param key
     * @return
     */
    public long getListSize(String key){
        Long size = redisTemplate.opsForList().size(key);
        return size == null ? 0 : size;
    }

    /**
     * 范围获取list的value
     * @param key
     * @return
     */
    public List getListValueRange(String key,long startIndex,long endIndex){
        return redisTemplate.opsForList().range(key, startIndex, endIndex);
    }

    /**
     * 从右边push数据到redisList
     */
    public void rightPushList(String key,Object data) {
        redisTemplate.opsForList().leftPush(key, JSON.toJSONString(data));
    }

    /**
     * 从右边push数据到redisList
     */
    public void rightPushListForObj(String key,Object data) {
        redisTemplate.opsForList().leftPush(key, data);
    }

    /**
     * bound设置map并设置过期时间
     * @param redisKey
     * @param hKey
     * @param value
     * @param second 过期时间，单位：秒
     */
    public void setCacheMapBoundExpire(String redisKey,String hKey,String value,Long second){
        redisTemplate.boundHashOps(redisKey).put(hKey,value);
        redisTemplate.boundHashOps(redisKey).expire(second,TimeUnit.SECONDS);
    }

    /**
     * bound设置map并设置过期时间
     * @param redisKey
     * @param hKey
     * @param value
     */
    public void setCacheMapBound(String redisKey,String hKey,Object value){
        redisTemplate.boundHashOps(redisKey).put(hKey,value);
    }

    /**
     * bound获取hash的值
     * @param redisKey
     * @param hKey
     */
    public Object getCacheMapBound(String redisKey,String hKey){
        return redisTemplate.boundHashOps(redisKey).get(hKey);
    }

    /**
     * bound获取hash的keys
     * @param redisKey
     * @return
     */
    public Set getCacheMapKeysBound(String redisKey){
        return redisTemplate.boundHashOps(redisKey).keys();
    }


    /**
     * 添加list到redis
     * @param key
     * @param value
     */
    public void setCacheListBound(String key,Object value){
        redisTemplate.boundListOps(key).leftPushAll(value);
    }

    /**
     * 获取全部list
     * @param key
     * @return
     */
    public List<SysDept> getCacheListBoundAll(String key){
        return redisTemplate.boundListOps(key).range(0, -1);
    }

    public void leftSetCacheBoundList(String key,Object value){
        redisTemplate.boundListOps(key).leftPush(value);
    }

    public List rightGetCacheBoundListAll(String key){
        return redisTemplate.boundListOps(key).range(0,-1);
    }

    /**
     * 添加对象缓存
     * @param key
     * @param value
     * @param seconds
     */
    public void setObjectBoundExpire(String key,Object value,long seconds){
        redisTemplate.boundValueOps(key).set(value,seconds,TimeUnit.SECONDS);
    }

    /**
     * 获取缓存对象
     * @param key
     * @return
     */
    public Object getObjectBound(String key){
        return redisTemplate.boundValueOps(key).get();
    }

    /**
     * 获取缓存过期时间
     * @param key
     * @return
     */
    public Long getBoundObjectExpireTime(String key){
        return redisTemplate.boundValueOps(key).getExpire();
    }

    /**
     * 根据部门id获取本部门以及上级部门id列表
     * @return
     */
    public List<String> getDeptIds(String deptId){
        List<String> ids = new ArrayList<>();
        ids.add(deptId);
        Object deptInCache = getCacheMapBound(Constants.SYS_DEPT_CACHE, deptId);
        SysDept sysDept = BeanUtil.toBean(deptInCache, SysDept.class);
        if(sysDept == null){
            return ids;
        }
        String[] split = sysDept.getAncestors().split(",");
        ids.addAll(Arrays.asList(split));
        return ids;
    }

}

import OSS from 'ali-oss'
import { getSTSToken } from '@/api/common/ossUtil'

/**
 * 第一个参数: el自定义上传的回调参数
 * 第二个参数：OSS客户端
 * 第三个参数：上传的文件名
 */
export function upload(e,fileName,vue) {
  return new Promise(((resolve, reject) => {
    //获取OSSClient
    createOSSClient().then((client) => {
      let percent = '0%';
      vue.$loading({
        lock: true,
        text: '正在上传: 0%'
      });
      client.multipartUpload(fileName, e.file, {
        progress: (p,checkpoint) => {
          console.log('进度:' + p);
          e.onProgress({percent: Math.floor(p * 100)}); // 触发el-upload组件的onProgress方法
          vue.$loading().setText('正在上传: ' + Math.floor(p * 100) + '%');
        }
        // mime: type,
      }).then((res) => {
        if(res.res.status === 200){
          //成功
          resolve(res);
        }else {
          reject(res);
        }
      }).catch((error) => {
        reject(error);
      }).finally(() => {
        vue.$loading().close();
      })
    })
  }));
}

//创建阿里云客户端
export function createOSSClient() {
  return new Promise(((resolve, reject) => {
    getSTSToken().then((res) => {
      //创建客户端
      let ossClient = new OSS({
        // yourRegion填写Bucket所在地域。以华东1（杭州）为例，Region填写为oss-cn-hangzhou。
        region: res.data.region,
        // 从STS服务获取的临时访问密钥（AccessKey ID和AccessKey Secret）。
        accessKeyId: res.data.accessKeyId,
        accessKeySecret: res.data.accessKeySecret,
        // 从STS服务获取的安全令牌（SecurityToken）。
        stsToken: res.data.securityToken,
        // 填写Bucket名称。
        bucket: res.data.bucketName
      });
      resolve(ossClient);
    }).catch((err) => {
      reject(err);
    })
  }))

}

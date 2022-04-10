import request from '@/utils/request'

// 获取STS临时授权令牌
export function getSTSToken() {
  return request({
    url: '/sts',
    method: 'get'
  })
}

// 获取签名链接
export function getSignUrl(params) {
  return request({
    url: '/oss/generateSignUrl',
    method: 'get',
    params: params
  })
}

// 文件是否已经存在
export function isExist(params) {
  return request({
    url: '/oss/isExist',
    method: 'get',
    params: params
  })
}

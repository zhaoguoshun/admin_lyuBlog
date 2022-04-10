import request from '@/utils/request'

// 获取数据
export const getData = () => {
  return request({
    url: '/dataScreen/get',
    method: 'get'
  })
}
//轮询刷新令牌
export const getPolling = () => {
  return request({
    url: '/dataScreen/heartbeat',
    method: 'get'
  })
}
import request from '@/utils/request'

// 查询设备信息列表
export function listDevices(txDevicesVo) {
  return request({
    url: '/devices/list',
    method: 'get',
    params: txDevicesVo
  })
}
export function Door(deviceId,type) {
  return request({
    url: '/devices/updateTime',
    method: 'post',
    data:{deviceId,type}
  })
}


// 开门测试
// export function Door() {
//   return request({
//     url: 'http://192.168.3.230:8080/deviceRequest/addTask',
//     method: 'post',
//     data:{requestType:"openMode", deviceId:"ac7c03bedfdadba"}
//   })
// }



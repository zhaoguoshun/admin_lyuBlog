import request from '@/utils/request'

// 查询设备信息列表
export function listDevicesSet(macAddr) {
  return request({
    url: '/easySet/getInfo/'+macAddr,
    method: 'get'
  })
}

// 修改设备信息
export function DevicesSet(txDevicesSimpleParameter) {
  return request({
    url: '/easySet/setDevice',
    method: 'post',
    data:txDevicesSimpleParameter
  })
}

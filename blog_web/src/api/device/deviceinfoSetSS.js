import request from '@/utils/request'

// 查询设备信息列表
export function listDeviceSetSs(macAddr) {
  return request({
    url: '/leaveSet/getData/'+macAddr,
    method: 'get'
  })
}

// 修改设备高级参数
export function updateDeviceSetSs(txAdvancedParameterSettings) {
  return request({
    url: '/leaveSet/updateData',
    method: 'post',
    data:txAdvancedParameterSettings
  })
}

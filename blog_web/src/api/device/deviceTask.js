import request from '@/utils/request'

// 开门
export function openMode(txDeviceId) {
  return request({
    url: '/deviceRequest/addTask',
    method: 'post',
    data: {
      requestType:"openMode",
      deviceId: txDeviceId
    }
  })
}

// 重启
export function reboot(txDeviceId,rebootType) {
  return request({
    url: '/deviceRequest/addTask',
    method: 'post',
    data: {
      requestType:"devReboot",
      deviceId: txDeviceId,
      rebootType: rebootType
    }
  })
}

// 清空设备
export function emptyDev(deviceId) {
  return request({
    url: '/deviceRequest/addTask',
    method: 'post',
    data: {
      requestType:"emptyDev",
      deviceId: deviceId
    }
  })
}

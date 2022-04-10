import request from '@/utils/request'

// 查询设备信息列表
export function listMeets(deviceId) {
  return request({
    url: '/meet/data/'+deviceId,
    method: 'get'
  })
}

// 查询所有设备信息列表
export function listMeetInfo(index,size) {
  return request({
    url: '/meet/datas?index='+index+'&size='+size,
    method: 'get'
  })
}

//搜索
export function searchInfo(searchNotes) {
  return request({
    url: '/meet/data',
    method: 'post',
    data:searchNotes
  })
}

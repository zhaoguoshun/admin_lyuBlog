import request from '@/utils/request'

// 查询访问记录列表
export function getMiniList() {
  return request({
    url: '/miniNote/getList',
    method: 'get'
  })
}
export function updateNotes(miniVisitReservation) {
  return request({
    url: '/miniNote/updateNotes',
    method: 'post',
    data:miniVisitReservation
  })
}

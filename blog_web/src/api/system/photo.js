import request from '@/utils/request'

// 查询照片列表
export function listPhoto(query) {
  return request({
    url: '/system/photo/list',
    method: 'get',
    params: query
  })
}

// 查询照片列表
export function listPhotoid(id) {
  return request({
    url: '/system/photo/list/'+id,
    method: 'get',
  })
}

// 查询照片详细
export function getPhoto(id) {
  return request({
    url: '/system/photo/' + id,
    method: 'get'
  })
}

// 新增照片
export function addPhoto(data) {
  return request({
    url: '/system/photo',
    method: 'post',
    data: data
  })
}

// 修改照片
export function updatePhoto(data) {
  return request({
    url: '/system/photo',
    method: 'put',
    data: data
  })
}

// 删除照片
export function delPhoto(id) {
  return request({
    url: '/system/photo/' + id,
    method: 'delete'
  })
}

// 导出照片
export function exportPhoto(query) {
  return request({
    url: '/system/photo/export',
    method: 'get',
    params: query
  })
}

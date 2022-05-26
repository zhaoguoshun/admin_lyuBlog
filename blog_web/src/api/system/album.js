import request from '@/utils/request'

// 查询相册列表
export function listAlbum(query) {
  return request({
    url: '/system/album/list',
    method: 'get',
    params: query
  })
}

// 查询相册详细
export function getAlbum(id) {
  return request({
    url: '/system/album/' + id,
    method: 'get'
  })
}

// 新增相册
export function addAlbum(data) {
  return request({
    url: '/system/album',
    method: 'post',
    data: data
  })
}

// 修改相册
export function updateAlbum(data) {
  return request({
    url: '/system/album',
    method: 'put',
    data: data
  })
}

// 删除相册
export function delAlbum(id) {
  return request({
    url: '/system/album/' + id,
    method: 'delete'
  })
}

// 导出相册
export function exportAlbum(query) {
  return request({
    url: '/system/album/export',
    method: 'get',
    params: query
  })
}

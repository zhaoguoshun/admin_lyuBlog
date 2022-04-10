import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listTalk(query) {
  return request({
    url: '/system/talk/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getTalk(id) {
  return request({
    url: '/system/talk/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addTalk(data) {
  return request({
    url: '/system/talk',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateTalk(data) {
  return request({
    url: '/system/talk',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delTalk(id) {
  return request({
    url: '/system/talk/' + id,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportTalk(query) {
  return request({
    url: '/system/talk/export',
    method: 'get',
    params: query
  })
}

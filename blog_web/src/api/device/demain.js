import request from '@/utils/request'

// 查询区域信息列表
export function listDemain(query) {
  return request({
    url: '/system/demain/list',
    method: 'get',
    params: query
  })
}

// 查询区域信息详细
export function getDemain(domainId) {
  return request({
    url: '/system/demain/' + domainId,
    method: 'get'
  })
}

// 新增区域信息
export function addDemain(data) {
  return request({
    url: '/system/demain',
    method: 'post',
    data: data
  })
}

// 修改区域信息
export function updateDemain(data) {
  return request({
    url: '/system/demain',
    method: 'put',
    data: data
  })
}

// 删除区域信息
export function delDemain(domainId) {
  return request({
    url: '/system/demain/' + domainId,
    method: 'delete'
  })
}

// 导出区域信息
export function exportDemain(query) {
  return request({
    url: '/system/demain/export',
    method: 'get',
    params: query
  })
}

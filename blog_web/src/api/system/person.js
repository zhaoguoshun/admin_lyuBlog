import request from '@/utils/request'

// 查询员工管理列表
export function listPerson(query) {
  return request({
    url: '/system/person/list',
    method: 'get',
    params: query
  })
}

// 查询员工管理详细
export function getPerson(staffid) {
  return request({
    url: '/system/person/' + staffid,
    method: 'get'
  })
}

// 新增员工管理
export function addPerson(data) {
  return request({
    url: '/system/person',
    method: 'post',
    data: data
  })
}

// 修改员工管理
export function updatePerson(data) {
  return request({
    url: '/system/person',
    method: 'put',
    data: data
  })
}

// 删除员工管理
export function delPerson(staffid) {
  return request({
    url: '/system/person/' + staffid,
    method: 'delete'
  })
}

// 导出员工管理
export function exportPerson(query) {
  return request({
    url: '/system/person/export',
    method: 'get',
    params: query
  })
}

// 下载用户导入模板
export function importTemplates() {
  return request({
    url: '/system/person/importTemplate',
    method: 'get'
  })
}


// 查询员工下拉树结构
export function treeselect() {
  return request({
    url: '/system/dept/treeselect',
    method: 'get'
  })

}

// 人员类型
export function getPostList() {
  return request({
    url: '/system/post/list',
    method: 'get'
  })
}


// 查询所有的区域信息
export function getTxDemainList() {
  return request({
    url: '/system/demain/list',
    method: 'get'
  })
}

//查询部门信息
export function getBuMenList() {
  return request({
    url: '/system/dept/list',
    method: 'get'
  })
}


//查询父级人员类型部门信息
export function getPortionPostList(arr) {
  return request({
    url: '/system/post/portionList',
    method: 'get',
    params:{
      arr
    }
  })
}

//生成小程序绑定二维码
export function generatePersonBindQrCode(personId) {
  return request({
    url: '/system/person/generatePersonBindQrCode/' + personId,
    method: 'get'
  })
}


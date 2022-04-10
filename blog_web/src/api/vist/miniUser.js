import request from '@/utils/request'

// 查询访客注册信息列表
export function listUser() {
  return request({
    url: '/miniManage/listInfo',
    method: 'get'
  })
}
//修改当前用户
export function updateUser(miniUser) {
  return request({
    url: '/miniManage/updateUser',
    method: 'post',
    data:miniUser
  })
}

//删除当前用户
export function deleteUser(id) {
  return request({
    url: '/miniManage/deleteUser',
    method: 'post',
    data:id
  })
}

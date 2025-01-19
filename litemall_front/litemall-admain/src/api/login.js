import request from "../utils/request.ts";

export function login(query) {
    return request({
      url: '/admin/login',
      method: 'post',
      params: query
    })
  }

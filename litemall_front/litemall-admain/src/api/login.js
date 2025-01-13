import request from "../utils/request.ts";

export function login(query) {
    return request({
      url: '/admain/login',
      method: 'post',
      params: query
    })
  }
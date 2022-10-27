import axios from "../config/axios";

// get user manage
export const getAllUsers = () => {
  return axios.get(`/list-product`);
};

export const createUser = (data) => {
  return axios.post(`/create-product`, data);
};

export const updateUser = (data) => {
  return axios.put(`/update-product`, data);
};

export const deleteUserService = (id) => {
  return axios.delete(`/delete-product/${id}`);
};

import axios from 'axios';
import { setInterceptors } from '@/api/common/interceptors';

// const BASE_URL = 'http://i8a505.p.ssafy.io/api/';
// const BASE_URL = 'http://localhost:8080/api/';
const API_SERVER_URL = import.meta.env.VITE_API_SERVER_URL;

const defaultConfig = {
  headers: {
    'Content-Type': 'application/json',
  },
  withCredentials: true,
};
const fileConfig = {
  ...defaultConfig,
  headers: {
    'Content-Type': 'multipart/form-data',
  },
};

function createInstance(path, config = defaultConfig) {
  const instance = axios.create({
    ...defaultConfig,
    baseURL: API_SERVER_URL + path,
  });
  return instance;
  // return setInterceptors(instance);
}

export { createInstance };

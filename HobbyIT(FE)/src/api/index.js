import axios from 'axios';
import { setInterceptors, setInterceptorsWithNoAuth } from '@/api/common/interceptors';
import { useUserStore } from '@/store/user';

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
    ...config,
    baseURL: API_SERVER_URL + path,
  });
  return setInterceptors(instance);
}

function createInstanceWithNoAuth(path, config = defaultConfig) {
  const instance = axios.create({
    ...config,
    baseURL: API_SERVER_URL + path,
  });
  return setInterceptorsWithNoAuth(instance);
}

export { createInstance, createInstanceWithNoAuth, fileConfig };

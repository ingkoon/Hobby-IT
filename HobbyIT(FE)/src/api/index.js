import axios from 'axios';
import { setInterceptors } from '@/api/common/interceptors';

const BASE_URL = 'https://i8a505.p.ssafy.io/api/';

const defaultConfig = {
  headers: {
    'Content-Type': 'application/json',
  },
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
    baseURL: BASE_URL + path,
  });
  return setInterceptors(instance);
}

export { createInstance };

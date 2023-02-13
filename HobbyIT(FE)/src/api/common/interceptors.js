import { useUserStore } from '@/store/user';
import axios from 'axios';

// function getRefreshToken() {
//   try {
//     const {}
//   } catch (e) {
//
//   }
// };
const API_SERVER_URL = import.meta.env.VITE_API_SERVER_URL;

async function reissueRefreshToken(data) {
  const res = await axios.post(API_SERVER_URL + '/member/reissue', data);
  return res;
}

function setInterceptors(instance) {
  const userStore = useUserStore();
  // 요청 인터셉터 추가하기
  instance.interceptors.request.use(
    function (config) {
      config.headers.Authorization = 'Bearer ' + userStore.getAccessToken;
      return config;
    },
    function (error) {
      // 요청 오류가 있는 작업 수행
      return Promise.reject(error);
    },
  );

  // 응답 인터셉터 추가하기
  instance.interceptors.response.use(
    function (response) {
      console.log(response, 'fulfilled');
      return response;
    },
    async function (error) {
      const {
        config,
        response: { status },
      } = error;
      const originalRequest = config;

      if (status === 401 && !!userStore.getRefreshToken) {
        const data = {
          refreshToken: userStore.getRefreshToken,
        };
        try {
          const res = await reissueRefreshToken(data);
          userStore.setAccessToken(res.data.accessToken);
          config.headers.Authorization = `Bearer ${res.data.accessToken}`;
          return axios(config);
        } catch (e) {
          console.log(e);
        }
      }
      return Promise.reject(error);
    },
  );
  return instance;
}

function setInterceptorsWithNoAuth(instance) {
  // 요청 인터셉터 추가하기
  instance.interceptors.request.use(
    function (config) {
      return config;
    },
    function (error) {
      // 요청 오류가 있는 작업 수행

      return Promise.reject(error);
    },
  );

  // 응답 인터셉터 추가하기
  instance.interceptors.response.use(
    function (response) {
      // 2xx 범위에 있는 상태 코드는 이 함수를 트리거 합니다.
      // 응답 데이터가 있는 작업 수행
      return response;
    },
    function (error) {
      // 2xx 외의 범위에 있는 상태 코드는 이 함수를 트리거 합니다.

      return Promise.reject(error);
    },
  );
  return instance;
}

export { setInterceptors, setInterceptorsWithNoAuth, reissueRefreshToken };

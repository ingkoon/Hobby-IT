import { createInstance, createInstanceWithNoAuth, fileConfig } from '@/api/index';

const PATH = '/article';

const instance = createInstance(PATH);
const multipartInstance = createInstance(PATH, fileConfig);
const instanceWithNoAuth = createInstanceWithNoAuth(PATH);
const multipartInstanceWithNoAuth = createInstanceWithNoAuth(PATH, fileConfig);

// 45.홍보 게시판 게시글 페이지 조회
export function getPromotionArticlePage(page_no) {
  return instance.get('', {
    params: {
      page: page_no,
    },
  });
}

// 46.홍보 게시판 게시글 등록
export function createPromotionArticle(data, hobby_id) {
  return instance.post(`/${hobby_id}`, data);
}

// 47.홍보 게시판 게시글 조회
export function getPromotionArticle(article_id) {
  return instance.get(`/${article_id}`);
}

// 48.홍보 게시판 게시글 수정
export function updatePromotionArticle(data, article_id) {
  return instance.put(`/${article_id}`, data);
}

// 49.홍보 게시판 게시글 삭제
export function deletePromotionArticle(article_id) {
  return instance.delete(`/${article_id}`);
}

// 50.홍보 게시판 내가 방장인 모임 가져오기
export function getMasterList() {
  return instance.get(`/possession`);
}

import { createInstance, fileConfig } from '@/api/index';

const PATH = '/hobby';

const instance = createInstance(PATH);
const multipartInstance = createInstance(PATH, fileConfig);

// 12.모임 리스트 확인
function getHobbyList() {
  return instance.get('');
}

// 13.모임 검색
function searchHobby(keyword) {
  return instance.get('', {
    params: {
      query: keyword,
    },
  });
}

// 14.인기있는 모임 리스트 확인
function getPopularHobbyList() {
  return instance.get('/popular');
}

// 15.새로생긴 모임 리스트 확인
function getFreshHobbyList() {
  return instance.get('/fresh');
}

// 16.모임생성
function createGroup(data) {
  console.log(multipartInstance, 'haha');
  return multipartInstance.post('', data);
}

// 17.모임 정보 확인
function getGroupInfo(hobby_id) {
  return instance.get(`/${hobby_id}`);
}

// 18.모임 회원 명단 확인
function getGroupMemberList(hobby_id) {
  return instance.get(`/${hobby_id}/member`);
}

// 19.모임 회원 권한 변경
function updateGroupMemberPrivilege(hobby_id, member_id, data) {
  return instance.put(`/${hobby_id}/member/${member_id}`, data);
}

// 20.모임 가입 강제 추방
function deleteGroupMember(hobby_id, member_id) {
  return instance.delete(`/${hobby_id}/member/${member_id}`);
}

// 21.모임 가입 신청
function requestGroupJoin(hobby_id, data) {
  return instance.post(`/${hobby_id}/join`, data);
}

// 22.모임 가입 신청 회원 리스트 확인
function getGroupJoinRequests(hobby_id) {
  return instance.get(`/${hobby_id}/join`);
}

// 23.모임 가입 신청 검증
function verifyGroupJoinRequest(hobby_id, data) {
  return instance.post(`/${hobby_id}/allow`, data);
}

// 24.모임 탈퇴
function resignGroup(hobby_id) {
  return instance.delete(`/${hobby_id}/member`);
}

// 25.모임 정보 변경
function updateGroupInfo(hobby_id, data) {
  return instance.put(`/${hobby_id}`, data);
}

// 26.모임 삭제
function deleteGroup(hobby_id) {
  return instance.delete(`/${hobby_id}`);
}

// 27.모임 게시판 게시글 리스트 확인
function getGroupArticleList(hobby_id) {
  return instance.get(`/${hobby_id}/article`);
}

// 28.모임 게시판 게시글 작성
function postGroupArticle(hobby_id, data) {
  return instance.post(`/${hobby_id}/article`, data);
}

// 29.모임 게시판 게시글 검색
function searchGroupArticle(hobby_id, keyword) {
  return instance.get(`/${hobby_id}/article`, {
    params: {
      query: keyword,
    },
  });
}

// 30.모임 게시판 게시글 조회
function getGroupArticle(hobby_id, article_id) {
  return instance.get(`/${hobby_id}/article/${article_id}`);
}

// 31.모임 게시판 게시글 수정
function updateGroupArticle(hobby_id, article_id, data) {
  return instance.put(`/${hobby_id}/article/${article_id}`, data);
}

// 32.모임 게시판 게시글 삭제
function deleteGroupArticle(hobby_id, article_id) {
  return instance.delete(`/${hobby_id}/article/${article_id}`);
}

// 33.모임 게시판 게시글 댓글 작성
function postGroupArticleComment(hobby_id, article_id, data) {
  return instance.post(`/${hobby_id}/article/${article_id}/comment`, data);
}

// 34.모임 게시판 게시글 댓글 조회
function getGroupArticleCommentList(hobby_id, article_id) {
  return instance.get(`/${hobby_id}/article/${article_id}/comment`);
}

// 35.모임 게시판 게시글 댓글 수정
function updateGroupArticleComment(hobby_id, article_id, comment_id, data) {
  return instance.put(`/${hobby_id}/article/${article_id}/comment/${comment_id}`, data);
}

// 36.모임 게시판 게시글 댓글 삭제
function deleteGroupArticleComment(hobby_id, article_id, comment_id) {
  return instance.delete(`/${hobby_id}/article/${article_id}/comment/${comment_id}`);
}

// 37.모임 공지사항 리스트 확인
function getGroupNoticeList(hobby_id) {
  return instance.get(`/${hobby_id}/notice`);
}

// 38.모임 공지사항 등록
function postGroupNotice(hobby_id, data) {
  return instance.post(`/${hobby_id}/notice`, data);
}

// 39.모임 공지사항 조회
function getGroupNotice(hobby_id, notice_id) {
  return instance.get(`/${hobby_id}/notice/${notice_id}`);
}

// 40.모임 공지사항 수정
function updateGroupNotice(hobby_id, notice_id, data) {
  return instance.put(`/${hobby_id}/notice/${notice_id}`, data);
}

// 41.모임 공지사항 삭제
function deleteGroupNotice(hobby_id, notice_id) {
  return instance.delete(`/${hobby_id}/notice/${notice_id}`);
}

// 42.모임 방명록 등록
function postGroupVisitorBook(hobby_id, data) {
  return instance.post(`/${hobby_id}/postit`, data);
}

// 43.모임 방명록 조회
function getGroupVisitorBook(hobby_id, date) {
  return instance.get(`/${hobby_id}/postit/${date}`);
}

export { createGroup };

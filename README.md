## 📆 프로젝트 개요
---
><p><strong>프로젝트</strong>: 쇼핑몰 형식의 소가전 중고거래 사이트</p>
><p><strong>기획 및 제작</strong>: 서원진, 윤소영, 강승권, 최경묵, 김성호</p>
><p><strong>제작 기간</strong>: 2023.08.14 ~ 2023. 09.15 
><p><strong>배포일</strong>: 2023.09.15</p>


## :open_file_folder: 목차
 팀원 소개
 Tech Stacks
 기능 구현

## 👨‍👨‍👧‍👧 팀원 소개
><p><strong>팀장</strong>: 서원진</p>
>총괄, 로그인, 회원가입 개발

><p><strong>팀원</strong>: 윤소영</p>
>상품 상세, 회원 프로필, 후기페이지, 관리자페이지 일부 개발

><p><strong>팀원</strong>: 강승권</p>
>공지사항, 1:1문의, 결제, 관리자페이지 일부 개발

><p><strong>팀원</strong>: 최경묵</p>
>메인 페이지, 상품관련페이지(리스트, 등록, 수정, 삭제) 개발

><p><strong>팀원</strong>: 김성호</p>
>마이페이지, 구매내역/판매내역, 채팅 개발





## 🔨 Tech Stacks
---

<img src="https://img.shields.io/badge/Design-%23121011?style=for-the-badge"> ![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white) <br/>

<img src="https://img.shields.io/badge/IDE-%23121011?style=for-the-badge"> ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)<br/>

<img src="https://img.shields.io/badge/Server Hosting-%23121011?style=for-the-badge"> ![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white) <br/>

<img src="https://img.shields.io/badge/DB-%23121011?style=for-the-badge"> ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white) <br/>

<img src="https://img.shields.io/badge/Languages-%23121011?style=for-the-badge"> ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) <br/>

<img src="https://img.shields.io/badge/OS-%23121011?style=for-the-badge"> ![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white) <br/>

<img src="https://img.shields.io/badge/Server-%23121011?style=for-the-badge"> ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black) <br/>

<img src="https://img.shields.io/badge/Other-%23121011?style=for-the-badge"> ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) ![Notion](https://img.shields.io/badge/Notion-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white) ![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white) ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white) 


## :rocket: <a id="function-implementation">기능 구현</a>
### 1.일반

#### 1-1.일반 회원가입

![회원가입](https://github.com/sungho9941/SemiProject/assets/26131124/751e9cea-b927-4f71-b6bf-ca9c57df1bd7)

* 먼저 회원 가입을 진행해야 사이트 내 기능을 이용할 수 있다.
  
#### 1-2.카카오 회원가입

![카카오회원가입](https://github.com/sungho9941/SemiProject/assets/26131124/b946a734-c0b9-4d96-9bf0-11df03b563a2)

* REST API중 HttpURLConnection을 사용하여 구현
* 최초 로그인 시 이메일, 프로필 사진,닉네임 등을 가져올 수 있다
* 실제로 사업자 등록을 하고 비즈 앱 신청을 해야만 유저의 다른 정보들을 가져올 수 있기에 현재는 이메일을 아이디로 써서 로그인

#### 1-3.상품 등록

![상품등록](https://github.com/sungho9941/SemiProject/assets/26131124/6f230951-7421-4d8a-b581-f02dfb7e52d8)

* 판매자가 등록한 상품 상세 설명이 있으며, 판매자 정보나 후기도 확인할 수 있음
* 상품 관련 이미지를 최대 5개까지 등록할 수 있음

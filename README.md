# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록 정리
### 구현 완료
- [X] 자동차 이름 검증 기능 구현
- - 자동차 이름 길이 5자 이하 검증
- - 자동차 이름 Null 및 빈 스트링 여부 검증
- - 자동차 이름 중복 검증
- [X] 자동차 게임 진행 횟수 검증 기능 구현
- - 1 이상의 양수 숫자 검증 
- - 숫자 여부 검증
- [X] 전진 판별 여부 기능 구현
- - 4 이상일 경우 전진, 3이하의 값이면 정지 구별
- [X] 우승자 판정 기능 구현
- - 해당 자동차가 우승인지 판정
- [X] 자동차 게임 결과 반환 기능 구현
- - 게임 진행도 반환 
- [X] 최종 우승자 반환 기능 구현
- - 최종 우승자 반환
- [X] 전진 조건 랜덤 값 생성 기능 구현
- - [0 - 9] 사이의 임의의 수 1개 생성
- [X] 입력 값 검증 및 상태 코드 반환 기능 구현
### 구현 미완료
- [ ] 자동차 이름 입력 기능 구현
- - 자동차 이름 쉼표로 분리
- [ ] 자동차 게임 진행 횟수 입력 기능 구현
- [ ] 게임 출력 기능 구현
- - 게임 시작 시 "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)" 출력
- - 자동차 이름 작성 후 "시도할 횟수는 몇회인가요?" 출력
- - 숫자 입력 후 게임 종료까지 실행 결과 반복 출력
- - 게임 종료 후 최종 우승자 출력
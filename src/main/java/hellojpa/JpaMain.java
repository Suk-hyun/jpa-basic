package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//    // 웹 애플리케이션을 만든다고 하면 emf 는 프로그램 뜰 때 db 당 딱 하나만 생성 되는 것.
//
//    EntityManager em = emf.createEntityManager();
//    // em 은 요청 하나가 올 때 마다 쓰고, em.close 로 버리고 하는 것.
//    // em 은 쓰레드 간에 절대 공유 X.
//    // em 은 transaction 물고 작동 하는 것 이어서, 마치 db connection 쓰고 빨리 돌려주 듯이 em 도 쓰고 빨리 close 로 버려야 함.
//
//    // JPA 의 모든 데이터 변경은 트랜잭션 안에서 실행 해야 한다. (다른 RDB 들 처럼)
//
//    // ** jpql 은 엔티티 객체를 대상으로 쿼리를 작성한다.
//    // jpql 로 작성한 쿼리는 (설정 해놓은 dialect 에 따라 db 에 해당 db dialect 로) (jpql 을 사용 db 가 바뀌어도 db 종속적으로 바꾸지 않아도 된다)
//    // sql 로 변환되어서 table 을 대상으로 sql 쿼리가 나가는 것이다. 그래서 table 종속적이지 않고 객체 지향인 jpa 의 패러다임이 유지 되는 것.
//    EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try { // 스프링 쓰면서 어노태이션 기반으로 할 거지만, 첫 시간 이니까, tx 쓰니까 정석 코딩은 이렇다.
//        tx.commit();
//    } catch (Exception e) {
//        tx.rollback();
//    } finally {
//        em.close();
//    }
//
//        emf.close();
//}

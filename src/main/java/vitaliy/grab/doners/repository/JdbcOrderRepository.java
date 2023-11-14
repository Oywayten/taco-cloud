package vitaliy.grab.doners.repository;

import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vitaliy.grab.doners.model.*;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Oywayten 12.11.2023.
 */
@Repository
public class JdbcOrderRepository implements OrderRepository {

    public static final String INSERT_ORDER =
            "insert into Doner_Order (delivery_name, delivery_street, delivery_city, delivery_state, delivery_zip, "
                    + "cc_number, cc_expiration, cc_cvv, placed_at)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String INSERT_DONER = "insert into Doner (name, created_at, doner_order, doner_order_key)"
            + "values (?, ?, ?, ?)";
    public static final String INSERT_INGREDIENT_REF = "insert into Ingredient_Ref (ingredient, doner, doner_key)"
            + "values (?, ?, ?)";
    private final JdbcOperations jdbcOperations;


    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }


    @Override
    @Transactional
    public Order save(Order order) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                INSERT_ORDER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP);
        pscf.setReturnGeneratedKeys(true);
        order.setPlaceAt(new Date());
        Delivery delivery = order.getDelivery();
        CreditCard creditCard = order.getCreditCard();
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        delivery.getName(),
                        delivery.getStreet(),
                        delivery.getCity(),
                        delivery.getState(),
                        delivery.getZip(),
                        creditCard.getNumber(),
                        creditCard.getExpiration(),
                        creditCard.getCvv(),
                        order.getPlaceAt()
                )
        );
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        order.setId(orderId);
        List<Doner> doners = order.getDoners();
        int i = 0;
        for (Doner doner : doners) {
            saveDoner(orderId, i++, doner);
        }
        return order;
    }

    private long saveDoner(Long orderId, int orderKey, Doner doner) {
        doner.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                INSERT_DONER, Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG);
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        doner.getName(),
                        doner.getCreatedAt(),
                        orderId,
                        orderKey
                )
        );
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long donerId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        doner.setId(donerId);
        saveIngredientsRefs(donerId, doner.getIngredients());
        return donerId;
    }

    private void saveIngredientsRefs(long donerId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(INSERT_INGREDIENT_REF, ingredientRef.getIngredient(), donerId, key++);
        }
    }
}

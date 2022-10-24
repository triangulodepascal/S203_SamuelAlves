package builder.pizzaria;

import org.junit.Test;
import static org.junit.Assert.*;

public class PizzariaBuilderTest {

	@Test
    public void deveConstruirUmaPizzaValida() {
        Pizza pizza = new PizzariaBuilder()
                .setTamanho(1)
                .addPepperoni(true)
                .addQueijo(true)
                .getPizza();

        assertNotNull(pizza);
        assertEquals(pizza.getTamanho(), Integer.valueOf(1));
        assertEquals(pizza.getPepperoni(), Boolean.TRUE);
        assertEquals(pizza.getQueijo(), Boolean.TRUE);


    }
	
	@Test
	public void deveInvalidarPizzaComTamanhoErrado() {
		try {
			Pizza pizza = new PizzariaBuilder()
					.setTamanho(9)
					.addQueijo(true)
					.addPepperoni(true)
					.getPizza();
			
			fail("Deveria ter lançado exception");
		} catch(IllegalStateException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deveInvalidarPizzaComIngredienteErrado() {
		try {
			Pizza pizza = new PizzariaBuilder()
					.setTamanho(9)
					.getPizza();
			
			fail("Deveria ter lançado exception");
		} catch(IllegalStateException e) {
			e.printStackTrace();
		}
	}
}

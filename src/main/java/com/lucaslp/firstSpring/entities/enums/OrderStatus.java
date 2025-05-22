package com.lucaslp.firstSpring.entities.enums;

public enum OrderStatus {
	
	//implementando os numeros do tipo enumerado manualmente, para melhor manutenção do codigo posteriormente, e diminuição de conflitos no banco de dados caso seja refatorado por outra pessoa ou seja adicionado novos valores nessa classe de enums!
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	//metodo para varrer os tipos de valores que tem na minha classe de enum a partir de um INT e ver se existe o tipo enumerado nessa classe com meus metodos auxiliares, se o numero não for correspondente, eu lanço uma exceção! 
	
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value: OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code!");
	}

}

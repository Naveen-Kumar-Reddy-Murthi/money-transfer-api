package org.mt.rest.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mt.constants.MTConstants;
import org.mt.exceptions.MTValidationException;
import org.mt.model.Status;
import org.mt.model.Transaction;
import org.mt.service.MTService;
import org.mt.servie.impl.MTServiceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/mt")
public class RestController {
	
	private final ObjectMapper mapper = new ObjectMapper();
	private Status status = new Status("1", "Transaction Successful!");
	
	private MTService service = new MTServiceImpl();
	
	@Path("/healthcheck")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String healthCheck() throws Exception {
		status = new Status("200", "money-transfer-api is up");
		return mapper.writeValueAsString(status);
	}
	
	@Path("/transfer")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String debit(Transaction txn) throws JsonProcessingException {

		try {

			System.out.println("incoming for debit ==>" + txn);

			if (null != txn && MTConstants.DEBIT.getValue().equalsIgnoreCase(txn.getType())) {

				if (null == txn.getTxnAmount()) {

					throw new MTValidationException(MTConstants.FAILED.getValue(),
							MTConstants.INVALID_TXN_AMT.getValue());
				}

				service.debit(txn);

			} else if (null != txn && MTConstants.CREDIT.getValue().equalsIgnoreCase(txn.getType())) {

				if (null == txn.getTxnAmount()) {

					throw new MTValidationException(MTConstants.FAILED.getValue(),
							MTConstants.INVALID_TXN_AMT.getValue());
				}

				service.credit(txn);

			} else {

				throw new MTValidationException(MTConstants.FAILED.getValue(), MTConstants.INVALID_REQUEST.getValue());
			}

		}

		catch (Exception exception) {
			status = new Status(MTConstants.FAILED.getValue(),exception.getMessage());
		}

		return mapper.writeValueAsString(status);
	}
	
	@Path("/getBalance")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String credit(Transaction txn) throws Exception {
	
		return mapper.writeValueAsString(status);
		
	}

}

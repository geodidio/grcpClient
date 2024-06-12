package grpc;

import com.acc.grpc.CompanyServiceGrpc;
import com.acc.grpc.UserProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

    public static void main(String[] args) {

        //Create a managed channed in a order to connect to server.
        ManagedChannel channel = ManagedChannelBuilder.
                forAddress("localhost", 9090).usePlaintext().build();
        //Creating a new blockingStub
        CompanyServiceGrpc.CompanyServiceBlockingStub companyStub = CompanyServiceGrpc.newBlockingStub(channel);
        //Request building.
        UserProto.CompanyRequest buildCompanyRequest = UserProto.CompanyRequest.newBuilder().setName("Accenture").setAmount(100).setRank(2).build();
        //Call server method.
        UserProto.Response response = companyStub.getTax(buildCompanyRequest);
        //Print response.
        System.out.println(response);

    }
}

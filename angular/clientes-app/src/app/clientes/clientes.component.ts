import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[];
  constructor(private clienteService: ClienteService) { }

  ngOnInit() {
   this.clienteService.getClientes().subscribe(
     (clientes) => {
       this.clientes = clientes
     }
   );
  }

  delete(cliente: Cliente): void {
    Swal.fire({
      title: 'Estás seguro?',
      text: `¿Seguro que deseas eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.value) {

        this.clienteService.delete(cliente.id).subscribe(
          reponse => {
            this.clientes = this.clienteService.filter(cli => cli !== cliente)
            Swal.fire(
              'Cliente eliminado!',
              `Cliente ${cliente.nombre} elimiando con éxito`,
              'success'
            );
          }
        );
      }
    });
  }

}

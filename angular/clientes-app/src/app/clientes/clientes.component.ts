import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import Swal from 'sweetalert2';
import { tap } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[];
  paginador: any;

  constructor(private clienteService: ClienteService,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(params => {
      let page: number = +params.get('page');

      if (!page) {
        page = 0;
      }
      this.clienteService.getClientes(page)
        .pipe(
          tap(response => {
            console.log('ClienteComponent: tap 3');
            (response.content as Cliente[]).forEach(cliente => {
              console.log(cliente.nombre);
            });
          })
        ).subscribe(response => {
          this.clientes = response.content as Cliente[];
          this.paginador = response;
        });
    });
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
            this.clientes = this.clienteService.filter(cli => cli !== cliente);
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
